package com.example.nutritiontracker;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NutritionLabelTest {

    private static final Random GEN = new Random();
    private static final int TYPE_COUNT = Macro.Type.values().length;

    public static int randomQtyLimit = 100;

    @Test
    public void test() {
        verifyRepeatMacros(50);
    }

    /// Verifies the expected behavior when constructing a NutritionLabel with duplicate Macro.Types
    private static void verifyRepeatMacros(int numTests) {
        for (int i = 0; i < numTests; ++i) {
            Set<Macro> macroSetDupes = generateRandomMacroSet(TYPE_COUNT, TYPE_COUNT * 2);
            Set<Macro> macroSet = Set.of(new Macro(Macro.Type.CALORIES, 100));

            assertThrows(UnsupportedOperationException.class, () -> new NutritionLabel("Arbitrary", new NutritionLabel.ServingSize(10, NutritionLabel.ServingSize.Type.GRAMS), macroSetDupes));
            assertDoesNotThrow(() -> new NutritionLabel("Arbitrary", new NutritionLabel.ServingSize(10, NutritionLabel.ServingSize.Type.GRAMS), macroSet));
        }
    }

    /**
     *
     * Generates a Set of random Macro Objects.</p>
     * Note: The set may still contain Macros with the same type.
     *
     * @param min Minimum number of randomly generated Macro Objects.
     * @param max Maximum number of randomly generated Macro Objects.
     * @return A Set with a random number of randomly generated Macro Objects.
     */
    private static HashSet<Macro> generateRandomMacroSet(int min, int max) {
        HashSet<Macro> randomMacros = new HashSet<>();

        int qty = GEN.nextInt(min,max);
        for (int i = 0; i != qty; ++i){
            randomMacros.add(generateRandomMacro());
        }

        if (randomMacros.size() < min)
            while (randomMacros.size() != min) {
                randomMacros.add(generateRandomMacro());
            }

        return randomMacros;
    }

    /**
     * Generates a single random Macro Object.
     * @return A randomly generated Macro Object.
     */
    private static Macro generateRandomMacro() {
        Macro.Type[] types = Macro.Type.values();
        return new Macro(types[Math.abs(GEN.nextInt())%TYPE_COUNT],GEN.nextInt());
    }
}
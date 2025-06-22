package com.example.nutritiontracker;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/// This class represents the data stored on a nutrition label.
class NutritionLabel {
    /// The name of the item whose nutrition facts is being stored.
    String itemName;
    ServingSize servingSize;
    /// Stores the nutrition info with O(1) time complexity for accessing the counts.
    Map<Macro.Type, Integer> label = new HashMap<>();

    /** Builds a new NutritionLabel with the provided arguments.
     *
     * @param itemName The name of the item whose nutrition facts is being stored.
     * @param macros nutrient data with the type of nutrient and the count of the nutrient.
     */
    NutritionLabel(String itemName, ServingSize servingSize, Collection<Macro> macros) {
        verifyMacrosInput(macros);
        this.itemName = itemName;
        this.servingSize = servingSize;

    }

    /** Verifies that the input data is valid.</p>
     * - Ensures that there is only one macronutrient per type.
     *
     * @param macros A collection of Macro Objects to iterate over.
     * @throws UnsupportedOperationException if the input is invalid.
     */
    private void verifyMacrosInput(Collection<Macro> macros) throws UnsupportedOperationException {
        StringBuilder errorLog = new StringBuilder();

        for (Macro macro : macros) {
            if (label.containsKey(macro.getType())) {
                errorLog.append(String.format("Duplicate inputs for Macro.Type: %s\n", macro.getType()));
            }
            else {
                label.put(macro.getType(), macro.getCount());
            }
        }
        if (!errorLog.isEmpty()) throw new UnsupportedOperationException(errorLog.toString());
    }

    static class ServingSize {
        int quantity;
        Type type;
        enum Type {GRAMS, OUNCES, LITERS, M_LITERS}

        ServingSize(int quantity, Type type) {
            this.quantity=quantity;
            this.type=type;
        }
    }

}
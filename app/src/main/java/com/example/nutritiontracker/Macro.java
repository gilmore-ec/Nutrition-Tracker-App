package com.example.nutritiontracker;

/**
 * Stores the type of macro-nutrient and the count of that macro-nutrient.
 */
class Macro {
    protected enum Type {CALORIES, PROTEIN, FIBER, ADDED_SUGARS, TOTAL_CARBS};

    /// The type of Macronutrient</p>
    /// One of:
    /// - Calories
    /// - Protein
    /// - Fiber
    /// - Added Sugars
    /// - Total Carbs
    private final Type type;

    ///  The weight in grams of the macronutrient
    private final int count;

    Macro(Type type, int count) {
        this.type=type;
        this.count=count;
    }

    public Type getType() {
        return type;
    }
    public int getCount() {
        return count;
    }
}

# To-Do List for App

## Author: Timothy Gilmore

### Contact

- [GitHub](https://github.com/gilmore-ec)
- [Email](https://gilmore-elegantcode.com/form.html)

## Initial Release

### Security

These features ensure that the application securely handles user's data.

- [ ] Implement Android's [Jetpack Security](https://developer.android.com/jetpack/androidx/releases/security) library for secure on-device encryption.

### MainActivity (Home)

This is the default activity for authenticated users. Shows previews of data reports/visualizations, notifications, and links to all other primary Activities.

- [ ] Handles user authentication.
- [ ] Displays the latest info for nutrition and biometrics for the day.
- [ ] Displays options for entering new data, and confirming data when a day's tracking has been completed.

### MealActivity

This activity is where the user enters or edits the measurements of the ingredients in their meals, so they can be automatically computed.

- [ ] Provides a search bar to find saved meals. The weights of the saved meal's ingredients can be adjusted as appropriate. Saving the meal after edits overrides the original meal, but adding the meal without saving does not override the original values.
- [ ] User enters the data for the meal here:
  - Meal name *(Optional)*
  - Ingredient, Quantity: 
    - The nutritional value is calculated based on the measurement given here divided by the serving size, then multiplied by each nutrient's respective value for the adjusted values for this ingredient.
    - The Ingredient name should reference an ingredient that has been added via the NutritionLabelActivity.
    - The Quantity should be measured in weight whenever possible, as volume is generally inaccurate. The Activity allows for various units for each type to accommodate all situations.
  - Add Another Ingredient button
- [ ] Add or Save (and add) the meal
  - Adding will not store the meal's values for later reuse or edits.
  - Saving the meal will add the meal and save the meal for reuse and later edits. Note that the meal **must** have a name in order to be saved.

### NutritionLabelActivity

This Activity is where the user enters the nutrition information for an Ingredient to be used within the MealActivity.

- [ ] Provides a search bar to find saved NutritionLabels. This also serves as the Name field for a new NutritionLabel. 
- [ ] User enters the data for the meal here:
  - Serving size and measurements (e.g. 28 grams, 1 ounce, or 28 milliliters, etc.)
  - Calories
  - Fat: *(Gross Total)* 
    - Unsaturated Fat *(Optional)*
    - Saturated Fat
    - Trans Fat
  - Cholesterol *(Optional)*
  - Sodium *(Optional)*
  - Carbohydrates: *(Gross Total)*
    - Net Carbs *(Optional)*
    - Fiber
    - Added Sugar
  - Protein: (Total)
    - Complete Protein *(Identified by dividing the daily value percentage by 2)*
- [ ] Confirmation button to save the NutritionLabel and return to the last Activity

### BiometricsActivity

This Activity is where the user may enter health biometrics like weight, body composition, and exercise data.

### ReviewActivity

This Activity is where the user will be able to review daily, weekly, monthly, and annual reports of their data. It would be easy to spot correlations between tracked eating and exercise behaviors with weight and body composition. The purpose is to provide insights into what the user's needs are and help them to reach their goals!

### Top Navigation Bar

This must be available from all Activities.

Handles account and settings

- [ ] Account management
- [ ] App settings
- [ ] App info/support

### Bottom Navigation Bar

This must be available from all Activities, however the specific buttons should change based on the current Activity.

Handles in-app navigation

- [ ] MainActivity (Home) button
- [ ] Buttons that launch relevant Activities
- [ ] Cancel/Back button for data entry Activities
- [ ] Save button for data entry Activities

## Improvements and Additions

### MealActivity ML Kit Integration

- [ ] The search bar has the ability to scan the Nutrition Label or barcode to have the nutrition facts data entered automatically.
    - Using Google's [ML Kit](https://developers.google.com/ml-kit) for [barcode scanning](https://developers.google.com/ml-kit/vision/barcode-scanning) and [text recognition](https://developers.google.com/ml-kit/vision/text-recognition/v2).
    - [ ] ML Kit sends usage data to Google, so there are some **compliance** implications and data **disclosures** needed to use this technology. To ensure complete privacy for the user, these implications need to be thoroughly reviewed.

### Health App Integrations

- [ ] Integrate with Google's [Health Connect](https://developer.android.com/health-and-fitness/guides/health-connect) APIs. Only used to ingest, and immediately encrypt the data using the user's secure encryption keys.

### Cloud Integration

- [ ] Integrate with AWS for securely storing the user's data, adding the ability for the user to access their data from the internet and freeing up device storage.

### MainActivity (Home)

- [ ] Provide monthly insights and data-driven suggestions based on their trends. (Disabled by default in account settings)

## Maintenance

### UX

- [ ] Daily data should be entered in separate sessions which all show the history of data entered on that same day (to avoid repeated entries).
- [ ] Completing a day's entries should not be confirmed on the same page as the session's submission form.

### Technical

- [ ] Refactor supporting java files (e.g. NutritionLabel.java, Macro.java, etc.) to a separate package for reusability and maintainability.
- [ ] Use secure encryption for all personal, health, and identifying data.


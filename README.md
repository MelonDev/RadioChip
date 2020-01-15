# RadioChip
## First step (Requires)
Changing from Theme.AppCompat to Theme.MaterialComponents on Styles.xml
```
<style name="AppTheme" parent="Theme.MaterialComponents.Light.DarkActionBar">
```
## How to use
Add RadioChipLayout to your target xml file
```
 <com.example.radiochip.RadioChipLayout
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:id="@+id/radio_chip_layout"
      />
```
Calling layout and declaration RadioChipController
```
RadioChipLayout layout = (RadioChipLayout) findViewById(R.id.radio_chip_layout);
RadioChipController controller = new RadioChipController(this, layout);
```
How to add RadioChip? Answer is ArrayList<String>, Add string did you want to ArrayList and add to controller
```
controller.addStringListToChips(getData());
```
After your config style successful, You should calling build()
```
controller.build();
```
## Controller
### Listener
Calling onChanged from controller, Listener will return RadioChip and Position of RadioChip that you checked 
```
controller.addListener(new RadioChipController.OnChangeListener() {
       @Override
       public void onChanged(RadioChip radioChip, int position) {
           //TODO
       }
   });
```
 ### DefaultChip
Calling set default RadioChip from controller, If your don't set controller, Controller will checked first RadioChip on list
```
controller.setDefaultPosition(2);
```
 
 
## Styles
Before! Your should declaration RadioChipStyle
```
RadioChipStyle style = new RadioChipStyle();
```
### IconColor
```
style.setIconColor(R.color.colorPrimary);
```
### ActiveIconColor
```
style.setActiveIconColor(R.color.colorAccent);
```
### RipperColor
```
style.setRipperColor(R.color.colorAccent);
```
### BackgroundColor
```
style.setBackgroundColor(R.color.colorWhite);
```

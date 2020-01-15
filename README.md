# RadioChip
##Install
First step, Add Jitpack to your gradle
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Second step, Add implementation to your dependencies
```
implementation 'com.github.MelonDev:RadioChip:9b9485c0f2fafe13daebb2dd3072df492a9449c0'
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
1. Calling layout and declaration RadioChipController
```
RadioChipLayout layout = (RadioChipLayout) findViewById(R.id.radio_chip_layout);
RadioChipController controller = new RadioChipController(this, layout);
```
2. How to add RadioChip? Answer is ArrayList<String>, Add string did you want to ArrayList and add to controller
```
controller.addStringListToChips(getData());
```
3. After your config style successful, You should calling build() 
```
controller.build();
```
Now! RadioChip is show on your layout! 😎😎😎
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
## Additional
Before using this library, You must changing from Theme.AppCompat to Theme.MaterialComponents on Styles.xml because Material Chip is use Material Components
```
<style name="AppTheme" parent="Theme.MaterialComponents.Light.DarkActionBar">
```

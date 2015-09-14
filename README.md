#Get Started with Android

##What will you learn?
 - You will learn the basics of Android development by creating a basic ToDo List app using Android Studio and native Android UI elements.

##Prerequisites
 - OOP concepts
 - Android Studio, SDK and Emulator 
 	[http://developer.android.com/sdk/index.html](http://developer.android.com/sdk/index.html) 	
 - Java [JRE](http://java.com/en/download/) and [JDK 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html) installed
 


#Lets get Started!

##Create a new Project

1. Open Android Studio select 'Start a new Android Studio Project', give it a name and choose where you want to save it. Package names are conventionally the reverse of your website domain (if you have one) in this case we could put `com.makersacademy`, but you can use anything you want.
2. Next we'll be asked what kind of device we want our app to run on, 'Phone and Tablet' should be selected by default, and here we select the minimum version of Android we will require to run our device on. Lets choose 4.1 Jelly Bean, because life is just better when you target Jelly Bean and up.
3. Now we will be asked to add an `Activity`. Our first UI screen. We can choose from a load of pre-baked implementations, but in this case we will create a 'Blank Activity'. 
4. We now provide 3 related names: Activity Name: the name of our Java class file defining our activity, Layout Name: the name of the XML file which defines the layout of this Activity. Title: The human name of the app to show at the top of the Activity when the app is running. Give the Title whatever name you want and leave the others. 'ToDo' might be a good one ;)
4. Hit 'Finish' and you've just created your first Android project!

## Run the project
So, Android Studio has gone ahead and given us 'Hello, World' to get us started. Let's run it first, then see what it is made up of.
So, we have two options here:

- If you have an Android phone, running Jelly Bean 4.1 and up, happy days! You can run it on your phone! Follow the steps below to get started.
- If you don't have an Android phone, sad times for you, but we can use the emulator to run it on your computer until you do get an Android device. Skip to the emulator section.

###Running the app on your phone
There are a few steps involved to get the app running on your phone. First we need to enable Developer Mode on your phone.

1. Open your phone's settings menu
2. Find the 'About phone' section
3. Find the entry that says 'Build number'
4. Tap it multiple times until it starts a countdown
5. You're now a Developer!
6. Go back to your phone's settings, you should see a new section called 'Developer Options' lets go in there!
7. Make sure 'USB debugging' is selected
8. Plug your phone into your computer
9. In Android Studio open up the 'Android' toolbar at the bottom of the window and make sure the 'logcat' tab is open. In the dropdown box, you should see your phone and all of the log messages from all the currently running apps you have will now be streaming in the logcat window!
	![image](images/logcat.png =480x)
10. Under the 'Run' Menu in Android Studio, select `Run 'app'`, this should install the app and run it on your phone!

###Running the app in the Emulator
Lets get a simulator up and running so you can test your app.

1. Under Tools - > Android in Android Studio select 'AVD Manager'
2. Select Create Virtual Device from the bottom left
3. Lets have a nice Nexus 5 to play with, select 'Nexus 5' from the phone category (confusingly, there are two, choose the one which says 'xxhdpi' under density)
4. Now lets choose our system Image, which is what version of Android we want to run. Select `Marshmallow, API - 23, ABI - x86_64, Target - Google APIs`. Make sure you install the Intel HAXM when prompted, otherwise the emulator will be woefully slow and you will hate yourself for not doing it. If the `x86_64` is not shown, check the 'Show downloadable system images' box and download it. The `armeabi` is just incredibly slow and will take the entire evening to boot.
	![image](images/AVD.png =640x)
5. Click next and give your AVD (Android Virtual Device) a name, check the 'Use host GPU' option and click 'finish'
6. Now start your emulator by clicking the play button in the right hand column of your new AVD. If it doesn't start properly make sure to close any other VMs you might be running.
7. Under the 'Run' Menu in Android Studio, select `Run 'app'`, this should install your app and run it on your new AVD!

###Our first app
Behold! Hello, World on Android! Isn't it useless! We want to make it do something more exciting. But first lets have a look at what we have. Back in AS there should be two tabs open in the editor, one Java file, and one XML file.

First the Layout XML file

	<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    	xmlns:tools="http://schemas.android.com/tools" 
    	android:layout_width="match_parent"
    	android:layout_height="match_parent" 
    	android:paddingLeft="@dimen/activity_horizontal_margin"
    	android:paddingRight="@dimen/activity_horizontal_margin"
    	android:paddingTop="@dimen/activity_vertical_margin"
    	android:paddingBottom="@dimen/activity_vertical_margin" tools:context=".MainActivity">

    	<TextView android:text="@string/hello_world" android:layout_width="wrap_content"
        	android:layout_height="wrap_content" />

	</RelativeLayout>


Layouts in Android are written in XML and, much like HTML for web, there are various tags and attributes. There are also XML namespaces which provide a lot of custom attributes, here we have the `android` namespace defined by `xmlns:android` on the first line. Every attribute which uses this namespace has to be prefixed with the namespace's name, hence all of the `android:blablabla`, which is a bit ugly...

Here we have two elements. One containing element - the `RelativeLayout` - which is filling the screen by having it's width and height match it's parent - in this case the screen. Inside this we have a `TextView`, with it's width and height set to stretch to wrap whatever content it contains, it also has a reference to the string "Hello, World!" in it, rather than havng the string hardcoded. We can hardcode this value here, but generally, we don't keep raw strings in our layout XMLs for 2 main reasons:

1. It clutters out layout, especially if there is a big blob of text
2. It's better for localisation. When our app goes global and we support different languages this same key can be used across different language files to fill this `TextView` with the correct text for the current language.

The same is true for the padding values on the `RelativeLayout` these `dimen` values may be different on devices with different pixel densties, screen sizes, orientations. They can also be hardcoded though. To inspect their actual values CMD click on the text after `@dimen/`

It's pretty easy at this point to see what we want to do with this file. But first lets take a look at the associated Java code (with imports omitted):

	public class MainActivity extends AppCompatActivity {

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	    }
	
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.menu_main, menu);
	        return true;
	    }
	
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Handle action bar item clicks here. The action bar will
	        // automatically handle clicks on the Home/Up button, so long
	        // as you specify a parent activity in AndroidManifest.xml.
	        int id = item.getItemId();
	
	        //noinspection SimplifiableIfStatement
	        if (id == R.id.action_settings) {
	            return true;
	        }
	
	        return super.onOptionsItemSelected(item);
	    }
	}
	
This is our Activity class, which inherits from `AppCompatActivity` a new(ish) variant of an `Activity` class which, as the name suggests allows for backwards COMPATibility of newer features, including Material Design elements, to older versions of Android.	
We also have 3 functions that have been generated, the first and most important of these is the `onCreate` function. This is what's known as a 'lifecycle callback' function and this will be called when the activity is created by the system. There are multiple lifecycle callbacks which can be implemented to define behaviours based on certain app lifecycle events e.g. The user closes the app, the user resumes the app, the user pressed the back button. Here is the basic lifecycle of an activity:

![image](http://developer.android.com/images/activity_lifecycle.png)

At the moment our `onCreate` is doing one thing, it's setting the content view to be the content of our XML file using a referece from a generated class called `R`. In Android, the generated `R` class is pretty important, it's the main way to get references to our XML definitions from Java code. `R.layout` will contain references to our layout files, `R.id` to get specfic layout elements by Id, `R.string` for strings, `R.drawable` for images and other xml defined dynamic drawable elements and so on.

The other two functions are there to provide the 'three dots' menu options, we won't be touching these today.

Now lets get editing!

##Changing our layout

Let's go back to our layout XML and modify it so we can use it for our ToDo list app. We will need 3 elements for our app, a list, an editable text area to type our items, and a button to save them.

1. First, lets get rid of that `TextView`. In it's place, we will put a `ListView` element instead, set it's attributes so that it's width matches its parent and it's height also matches it parent - the `RelativeLayout`.
2. After the `ListView` as the next child of the `RelativeLayout` create a new `EditText` element. This should also match it's parent in width, but set it's height to `wrap_content`.
3. Lastly add the `Button` element. We want this to `wrap_content` for width and height, so that it only occupies the space that it needs to show all of it's text. Set it's text attribute `android:text` to be "Add" or "Create" or whatever you want. You can hard code this for now, but refactor it to pull the value out into the strings file later.

Lets look at the preview window and see what we have:

![image](images/preview_step1.png =480x)

Hmmmm. That's not great, everything is bunched up in the top left corner. That's because we are using a `RelativeLayout` as our container element. A `RelativeLayout` allows it's child elements to position themselves relative to their parent and/or other child elements. So lets add a few rules in so we can get this looking the way we want. In simple terms we want:

1. The `Button` on the bottom right of the screen, below the list
2. The `EditText` aligned to the bottom of the screen
1. The `EditText` below the list
2. The `EditText` to the left of the `Button`

Lets add these in:

1. In our `EditText` and `Button` add an attribute `android:layout_alignParentBottom="true"`
2. In the `Button` add `android:layout_alignParentRight="true"`

But we have a problem now. We want to set the remaining rules relative to each other, but first we need a way for one element to reference another. For this we use IDs. Sadly, this isn't just `id=bla`, it's a bit more verbose. Lets give our button an id `btn_add_todo_item` by adding the following attribute to the button: `android:id="@+id/btn_add_todo_item"`, now give the id `edit_new_item` to our `EditText` and `list_todos` to our `ListView`. 

(N.B. These ids generate the appropriate values in the `R` class, so we should now have access to our button via `R.id.btn_add_todo_item` in our Java class, this will come in handy later!)

Now that all our view elements have ids, we can finish our layout rules.

1. Add `android:layout_toLeftOf="@+id/btn_add_todo_item"` to our `EditText`
2. Add `android:layout_above="@+id/btn_add_todo_item"` to our `ListView`

Lets have another look at our Preview:

![image](images/preview_step2.png =480x)

Fit for the Play Store!!

Now that our layout is done, lets write some actual code and give it some behaviour in our `Activity` Java class.

##Do some Activity!




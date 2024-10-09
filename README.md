# Three Layer Books Example

A simple "three-layer architecture" example to illustrate how different UIs can access the same business logic layer
to allow us to separate the UI from the "core app" under the hood.

The second branch, gui, also adds a JavaFX build, but hasn't been merged as installing JavaFX can be higher effort.

This application is working, but you need to specify an API key.

You can sign up for an account here: https://developer.nytimes.com/apis 

Once you have an account, you can create an app with the Books API enabled for free here:

https://developer.nytimes.com/my-apps (simply go to +New App in the top right if you don't see anything)

From there, simply drop a file named nytimes.key into the resources folder.




The contents of the file should be your non-secret key

# Assignment 3: Favorite Calculator

An Android application that provides a model-view-presenter (MVP) and model-view-viewmodel (MVVM)
implementation of a basic calculator.

### GitHub Link

The GitHub link for this project is https://github.com/sam-schu/cs4520-assignment3.

### Getting Started

To run the project, open it in Android Studio, select a device to emulate (this project was tested
primarily with an emulated Pixel 5), and press the Run button at the top of the window. The buttons
on the home fragment (main menu) and the device's back button can be used for navigation.

### Project Overview

This is a single-activity application with three fragments. When the user initially opens the app,
the home fragment is displayed; this fragment includes buttons to move to the MVP fragment or the
MVVM fragment. Each of these fragments is functionally identical as a basic 4-function calculator,
but the logic for the MVP fragment is implemented using a presenter, and the logic for the MVVM
fragment is implemented using a view model. Toasts are displayed if a calculation cannot be
performed or results in an invalid value.

### Project Structure

The project code is divided into two packages under the com.cs4520.assignment3 package: state and
view. The state package includes the necessary classes and files for the presenter and view model.
The view package includes the necessary classes and files for the activities and fragments that
comprise the app. Layout XML files used by the application can be found in the project's res folder.
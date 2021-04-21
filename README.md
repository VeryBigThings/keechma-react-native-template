# Keechma React Native Template project

Starter template for building React Native apps with Keechma Next framework

## Guides (wip)

Android environment setup:
add `local.properties` file to the `/android` folder with the content:
`sdk.dir=/Users/{your_username}/Library/Android/sdk`

For other ENV setup options refer to the docs:
https://reactnative.dev/docs/environment-setup

How to run develop:

1. `yarn install`
2. for IOS project - `npx pod-install`
3. `shadow-cljs watch app`
4. when shadow is done, open new terminal window and run `npx react-native run-ios` or `npx react-native run-android`

## Project Rename
To rename the project from default template name, use this package:
https://github.com/junedomingo/react-native-rename

Run `npx react-native-rename "Travel App" -b com.junedomingo.travelapp`

Rename the root component name in `main.cljs`
Use XCode to update IOS bundle identifier. 

## Tailwind

This project uses Tailwind CSS adapted for React Native. Not all classes are available on RN.
Refer to this list: https://github.com/vadimdemedes/tailwind-rn#supported-utilities
Be sure to compare with the installed version (currently 3.0.1.)

## Dark Mode support

Currently only light mode (forced)

## EXPO support

This project is not an EXPO managed project, however it is using Expo Unimodules package and so it is enabled to install and use any Expo package.
See full supported list here:
https://docs.expo.io/bare/unimodules-full-list/

## Splash Screen

Splash screen is implemented with: https://github.com/expo/expo/tree/master/packages/expo-splash-screen
With the help of this tool: https://github.com/expo/expo-cli/tree/master/unlinked-packages/configure-splash-screen

Default Splash Screen image is added. To change the image, change the file in `/assets/images/splash.png`.

## React Navigation

## Keechma

## Helix

# keechma-react-native-template

Starter template for building React Native apps with Keechma Next framework

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

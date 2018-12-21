# Installation

To use this repo, you'll need to create a database with firebase, and copy the `google-services.json` in the app folder.

Also, your database should be structured as the `test-data.json` file given. (You may import it as is, or you may use the same structure with your
own data.)

Don't forget to : use a realtime database AND set the .read rule to true.

the app is in the app folder, and the cloud function for firebase in the functions folder.

to deploy the functions to the firebase space, run

```
firebase login
firebase use your_firebase_app_project
firebase deploy --only functions
```

you'll need to have the firebase cli tool installed, and the project should be linked with your
firebase project for the database.

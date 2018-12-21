const functions = require('firebase-functions');

// The Firebase Admin SDK to access the Firebase Realtime Database.
const admin = require('firebase-admin');
admin.initializeApp();

exports.sendPushNews = functions.database.ref('/news/{pushId}')
	.onCreate((snapshot, context) => {
		// fcmToken =
		// console.log(snapshot.ref.parent.child('test'));
		// console.log("first");
		let ret = admin.database().ref(`/`).child("fcmToken").once('value').then((snapshot) => {
			console.log(snapshot.val());
		}).catch(error => console.log(error));
		// console.log("second")
		// console.log(snapshot.ref.parent.parent.parent);
		// console.log(snapshot.ref.parent.parent.parent.parent);
		console.log(snapshot.val());
		// let setSecondTest = snapshot.ref.parent.parent.child("other test").set("other tested value");
		// let setFirstTest = snapshot.ref.parent.child('test').set("tested value");
		return ret;
	});
// // Create and Deploy Your First Cloud Functions
// // https://firebase.google.com/docs/functions/write-firebase-functions
//
// exports.helloWorld = functions.https.onRequest((request, response) => {
//  response.send("Hello from Firebase!");
// });

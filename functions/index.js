const functions = require('firebase-functions');

// The Firebase Admin SDK to access the Firebase Realtime Database.
const admin = require('firebase-admin');
admin.initializeApp();

exports.sendPushNews = functions.database.ref('/news/{pushId}')
	.onCreate((snapshot, context) => {
		// fcmToken =
		// console.log(snapshot.ref.parent.child('test'));
		// console.log("first");
		let newArticleData = snapshot.val();

		let ret = admin.database().ref(`/`).child("fcmToken").once('value')
			.then((snapshot) => {
				const fcmToken = snapshot.val();

				const payload = {
					notification: {
						title: "A new article!",
						body: "Tap to discover our new article",
						data: newArticleData.toString()
					}
				};

				return admin.messaging().sendToDevice(fcmToken, payload).then((response) => {
					console.log("Successfully sent message: ", response);
					return true;
				})
				.catch((error) => {
					console.log("Error sending message: ", error);
					return false;
				})
			})
			.catch(error => console.log(error));
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

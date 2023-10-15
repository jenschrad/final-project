const {app, BrowserWindow} = require("electron");

function Main() {
    const launchCRM = new BrowserWindow({
        title: "Simple CRM",
        width: 1500,
        height: 800,
    });

    const appURL = "http://localhost:8080";

    launchCRM.loadURL(appURL);
}

app.whenReady().then(Main)

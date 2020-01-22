package eckersley.ui;

import eckersley.apis.HTTPClient;
import eckersley.ui.components.CustomMainFrame;

import javax.swing.*;

public class UIHandler extends CustomMainFrame
{


    HTTPClient dataClient;
    public UIHandler() {
        dataClient = new HTTPClient();

    }

    public HTTPClient getDataClient() {
        return dataClient;
    }
}
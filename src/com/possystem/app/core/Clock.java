package com.possystem.app.core;

import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.net.URL;
import javafx.animation.*;
import javafx.event.*;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.Calendar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Clock extends Label
{
    private static DateTimeFormatter SHORT_TIME_FORMATTER =  DateTimeFormatter.ofPattern("HH:mm:ss");

    public Clock()
    {
        bindToTime();
    }

    private void bindToTime() {
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(0),
                            new EventHandler<ActionEvent>() {
                                @Override public void handle(ActionEvent actionEvent) {
                                    Calendar time = Calendar.getInstance();
                                    String hourString = StringUtilities.pad(2, ' ', time.get(Calendar.HOUR) == 0 ? "12" : time.get(Calendar.HOUR) + "");
                                    String minuteString = StringUtilities.pad(2, '0', time.get(Calendar.MINUTE) + "");
                                    String secondString = StringUtilities.pad(2, '0', time.get(Calendar.SECOND) + "");
                                    String ampmString = time.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
                                    setText(hourString + ":" + minuteString + ":" + secondString + " " + ampmString);
                                }
                            }
                    ),
                    new KeyFrame(Duration.seconds(1))
            );
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
    }
}

class StringUtilities {
    /**
     * Creates a string left padded to the specified width with the supplied padding character.
     * @param fieldWidth the length of the resultant padded string.
     * @param padChar a character to use for padding the string.
     * @param s the string to be padded.
     * @return the padded string.
     */
    public static String pad(int fieldWidth, char padChar, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i < fieldWidth; i++) {
            sb.append(padChar);
        }
        sb.append(s);

        return sb.toString();
    }
}
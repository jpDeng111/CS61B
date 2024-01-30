import synthesizer.GuitarString;

import java.util.*;

public class GuitarHero {

    public static void main(String[] args) {

        /* create two guitar strings, for concert A and C */

        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        synthesizer.GuitarString stringInput = null;
        ArrayList<GuitarString> stringList = new ArrayList<>();
        for (int i = 0; i <37; i++) {
            stringList.add(new GuitarString(440 * Math.pow( 2.0, ( i - 24 )/ 12 )));
        }

        int pointer;
        double sample = 0;

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                pointer = keyboard.indexOf(key);

                if (pointer != -1) { //play music
                    stringInput = stringList.get(pointer);
                    stringInput.pluck();
                }

            }
            // add all the sample of the GuitarString in the stringList
            for (int i = 0; i <37; i++) {
                sample += stringList.get(i).sample();
            }

            StdAudio.play(sample);
            for (int i = 0; i <37; i++) {
                stringList.get(i).tic();
            }
            sample = 0;
        }
    }
}

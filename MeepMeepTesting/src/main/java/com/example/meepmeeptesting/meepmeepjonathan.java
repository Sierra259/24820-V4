package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class meepmeepjonathan {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(750);



        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(14, -61, Math.toRadians(90)))
                .waitSeconds(2)
                //.afterTime(0, null)
                .strafeTo(new Vector2d(10, -34))
                //put arm up while strafing
                //stop at (10, -34) and place the sample on the bar
                .waitSeconds(2)
                .setReversed(true)
                //.afterTime(0, )



                .splineToConstantHeading(new Vector2d(46, -20), Math.toRadians(-90))

                .splineToConstantHeading(new Vector2d(46, -50), Math.toRadians(-90))
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
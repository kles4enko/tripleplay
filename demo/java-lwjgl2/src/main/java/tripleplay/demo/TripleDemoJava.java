//
// Triple Play - utilities for use in PlayN-based games
// Copyright (c) 2011-2018, Triple Play Authors - All rights reserved.
// http://github.com/threerings/tripleplay/blob/master/LICENSE

package tripleplay.demo;

import java.util.List;

import com.google.common.collect.Lists;

import playn.core.Image;
import playn.java.JavaPlatform;
import playn.java.LWJGLPlatform;

import tripleplay.platform.JavaTPPlatform;

public class TripleDemoJava
{
    public static void main (String[] args) {
        LWJGLPlatform.Config config = new LWJGLPlatform.Config();
        config.appName = "Tripleplay Demo (LWJGL2)";

        List<String> mainArgs = Lists.newArrayList();
        String size = "--size=";
        for (int ii = 0; ii < args.length; ii++) {
            if (args[ii].startsWith(size)) {
                String[] wh = args[ii].substring(size.length()).split("x");
                config.width = Integer.parseInt(wh[0]);
                config.height = Integer.parseInt(wh[1]);
            }
            // else if (args[ii].equals("--retina")) config.scaleFactor = 2;
            else mainArgs.add(args[ii]);
        }

        TripleDemo.mainArgs = mainArgs.toArray(new String[0]);
        LWJGLPlatform plat = new LWJGLPlatform(config);
        JavaTPPlatform tpplat = new JavaTPPlatform(plat, config);
        tpplat.setIcon(loadIcon(plat));
        new TripleDemo(plat);
        plat.start();
    }

    protected static Image loadIcon (JavaPlatform plat) {
        return plat.assets().getImageSync("icon.png");
    }
}

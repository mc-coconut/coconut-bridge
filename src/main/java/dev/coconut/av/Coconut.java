package dev.coconut.av;


import dev.coconut.av.detection.scantime.IDetection;
import dev.coconut.av.detection.scantime.impl.Weedhack;
import org.objectweb.asm.tree.ClassNode;

import java.util.Arrays;
import java.util.List;

public class Coconut {

    private static Coconut instance;
    private List<IDetection> detections = Arrays.asList(
            new Weedhack()
    );

    public static Coconut getInstance() {
        if(instance == null)
            instance = new Coconut();
        return instance;
    }

    public void scan(ClassNode classNode) {
        for(IDetection d : detections) {
            d.process(classNode);
        }
    }

    public native void terminate(String detectionType, String check, String message);
}

package dev.coconut.av.detection.scantime;

import org.objectweb.asm.tree.ClassNode;

public abstract class IDetection {

    public abstract void process(ClassNode classNode);

}

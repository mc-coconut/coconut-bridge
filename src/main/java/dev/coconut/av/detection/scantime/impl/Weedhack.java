package dev.coconut.av.detection.scantime.impl;

import dev.coconut.av.Coconut;
import dev.coconut.av.detection.scantime.IDetection;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Arrays;
import java.util.List;

public class Weedhack extends IDetection {


    @Override
    public void process(ClassNode classNode) {
        List<String> flag = Arrays.asList(
                "Mod init state: M0", "Mod init state: M1", "[EFN] ern", "Mod init state: M3 "
        );
        for(MethodNode mn : classNode.methods) {
            for(AbstractInsnNode node : mn.instructions) {
                if(node instanceof LdcInsnNode) {
                    LdcInsnNode ldc = (LdcInsnNode) node;
                    if(ldc.cst instanceof String && flag.contains(ldc.cst)) {
                        Coconut.getInstance().terminate("static", "weedhack", "found weedhack strings in class " + classNode.name);
                    }

                }
            }
        }
    }
}

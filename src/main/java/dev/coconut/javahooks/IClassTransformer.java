package dev.coconut.javahooks;

import org.objectweb.asm.tree.ClassNode;

public abstract class IClassTransformer {
    private final String className;

    public IClassTransformer(final String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }

    public abstract void process(final ClassNode classNode);
}
package org.tvscript.ga.general;

public interface Generator<R extends Representation> {

    R generate();
}
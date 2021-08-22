package com.dz.springboot_demo.demo;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class DzImport implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{Demo2Service.class.getName(),Demo1Service.class.getName()};
    }
}

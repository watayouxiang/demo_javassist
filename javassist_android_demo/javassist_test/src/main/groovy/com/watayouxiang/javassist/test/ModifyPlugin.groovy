package com.watayouxiang.javassist.test


import org.gradle.api.Plugin
import org.gradle.api.Project

class ModifyPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        println "---------------------> ModifyPlugin"
        project.android.registerTransform(new ModifyTransform(project))
    }
}

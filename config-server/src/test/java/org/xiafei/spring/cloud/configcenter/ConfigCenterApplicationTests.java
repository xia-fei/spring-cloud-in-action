package org.xiafei.spring.cloud.configcenter;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.Test;

import java.io.File;


public class ConfigCenterApplicationTests {

    @Test
    public void contextLoads() throws GitAPIException {

        Git git= Git.cloneRepository()
                    .setURI("git@github.com:xia-fei/git-learn.git")
                    .setDirectory(new File("gitProject"))
                    .call();


    }

}

package fr.inria.spirals.repairnator.utils;

import fr.inria.spirals.repairnator.serializer.engines.json.JSONFileSerializerEngine;
import org.junit.Test;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestUtils {

    @Test
    public void testGithubUserNamePattern() {
        // Valid GitHub usernames
        String userName = "lucesape";
        assertThat(userName.matches(Utils.GITHUB_USER_NAME_PATTERN), is(true));

        userName = "LucEsape";
        assertThat(userName.matches(Utils.GITHUB_USER_NAME_PATTERN), is(true));

        // Invalid GitHub usernames
        userName = "-luc-esape-";
        assertThat(userName.matches(Utils.GITHUB_USER_NAME_PATTERN), is(false));
    }

    @Test
    public void testGithubRepoNamePattern() {
        // Valid GitHub repository names
        String repoName = "repairnator";
        assertThat(repoName.matches(Utils.GITHUB_REPO_NAME_PATTERN), is(true));

        repoName = "repair-nator";
        assertThat(repoName.matches(Utils.GITHUB_REPO_NAME_PATTERN), is(true));

        // Invalid GitHub repository names
        repoName = "repair$nator";
        assertThat(repoName.matches(Utils.GITHUB_REPO_NAME_PATTERN), is(false));
    }

    @Test
    public void testSerializer() {
        JSONFileSerializerEngine j = new JSONFileSerializerEngine("./tt/ff/") {
            private final String basePath = "./tt/ff/";

            @Override
            public String getFileName() {
                return Paths.get(basePath, "defaultfilename.json").toString();
            }
        };
        String expectedPath = "./tt/ff/defaultfilename.json".replace("/", java.io.File.separator);
        assertEquals(expectedPath, j.getFileName());
    }

    @Test
    public void testSerializerWithNestedDirectories() {
        JSONFileSerializerEngine j = new JSONFileSerializerEngine("./nested/dir/") {
            private final String basePath = "./nested/dir/";

            @Override
            public String getFileName() {
                return Paths.get(basePath, "nestedfile.json").toString();
            }
        };
        String expectedPath = "./nested/dir/nestedfile.json".replace("/", java.io.File.separator);
        assertEquals(expectedPath, j.getFileName());
    }
}

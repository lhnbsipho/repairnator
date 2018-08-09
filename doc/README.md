# Documentation

This directory provides a general documentation about Repairnator project.

## Overview

Repairnator's project aimed at creating a bot to automatically repair failing builds coming from Travis CI.
By repairing we mean proposing patches that make the entire test-suite passing on a given build.

Another project, called BEARS, was built as a collaboration and aimed at creating a database of bugs by mining bugs and patches on Travis CI and Github.

We will mostly rely on Repairnator on this documentation.

## Terminology

We use in Repairnator a lot of different IDs or names to identify things.
So here a little bit of terminology to help the reader:
 - *build ID*: it's a Travis CI ID for the build of a repository. If you see an URL like this one: https://travis-ci.org/surli/failingProject/builds/413285802 then the build ID is `413285802`.
 - *Run ID*: it's a UUID generated by our own scripts using `uuid` UNIX tool to distinguish different Repairnator runs;
 - *Repository name (or slug)*: unless it's specified if we talk about a repository name, it's the Github *slug*: for repairnator it's `Spirals-Team/repairnator`;
 - *Travis/Github Repository ID*: we might sometimes use specific IDs from third-party API like the Travis CI Repository ID we use to blacklist some repository: we explicit the tool in those cases, 
 but not that you may need to interrogate the third-party APIs to retrieve those IDs.

## Usage

There are several ways to use Repairnator.
We tried to document some of them in [usage](usage) directory.

## Contributing

Contribution on Repairnator are more than welcome!
A first way to contribute is to look on the label [good-first-issue](https://github.com/Spirals-Team/repairnator/labels/good-first-issue).

Another way for contributing is to add a new program repair tool in Repairnator: [we provided a guide to help us](contributing/add-repair-tool.md).

## Chores

As part of using Repairnator, you might need to do some chores, like managing a MongoDB database.
We provided some documentation [about backups](chore/managedb.md) and [about MongoDB collection schema](chore/mongo).

## Program repair tools used in Repairnator

The following is the list of program repair tools currently supported in Repairnator:
  - Nopol
  - NPEFix
  - Astor
  - AssertFixer
  
For more information about the program repair tools and their strategies implemented in Repairnator, [have a look on this page](usage/repair-tools.md).
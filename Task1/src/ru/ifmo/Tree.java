package ru.ifmo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bigdreamer on 08.05.17.
 */
public class Tree {
    String node;
    List<Tree> children;

    public Tree(String node, Tree... children) {
        this.node = node;
        this.children = Arrays.asList(children);
    }

    public Tree(String node) {
        this.node = node;
    }
}

package test.DesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengdongqi on 17-10-23.
 */
public class VisitorPattern {
  Visitor pv = new PackageVisitor();
  Visitor fv = new FileVisitor();

  static abstract class Node {
    String name;

    void print() {
    }

    void accept() {
    }
  }

  static class Package extends Node {
    List<Node> list = new ArrayList<>();

    Package(String name) {
      this.name = name;
    }

    public Package() {

    }

    void print() {
      System.out.println("Visit Package " + name);
    }

    void add(Node node) {
      list.add(node);
    }

    void accept(Visitor visitor) {
      visitor.visit(this);
    }
  }

  static class File extends Node {
    File(String name) {
      this.name = name;
    }

    void print() {
      System.out.println("Visit file " + name);
    }

    void accept(Visitor visitor) {
      visitor.visit(this);
    }
  }

  interface Visitor {
    void visit(File file);
    void visit(Package packege1);
  }

  static class FileVisitor implements Visitor {
    public void visit(File node) {
      node.print();
    }
    public void visit(Package node) {
      node.print();
    }
  }

  static class PackageVisitor implements Visitor {
    public void visit(File node) {
      node.print();
    }
    public void visit(Package node) {
      node.print();
      for (Node node1 :  node.list) {
//        visit(node1);
      }
    }
  }

  static class LSVisitor implements Visitor {
    public void visit(File node) {
      node.print();
    }
    public void visit(Package node) {
      node.print();
      for (Node node1 :  node.list) {
        if(node1 instanceof File) {
          visit((File)node1);
        }else {
          visit((Package)node1);
        }
      }
    }
  }

//  public void action(Node node) {
//    if (node instanceof File)
//      fv.visit(node);
//    else {
//      pv.visit(node);
//      for (Node node1 : ((Package) node).list) {
//        action(node1);
//      }
//    }
//  }

  public static void main(String args[]) {
//    VisitorPattern vp = new VisitorPattern();
    Visitor v = new LSVisitor();
    Package p = new Package("p1");
    Package p2 = new Package("p2");
    p.add(new File("f1"));
    p.add(p2);
    p2.add(new File("p2f1"));
    p.add(new File("f3"));
    p.add(new File("f4"));
    v.visit(p);


  }
}


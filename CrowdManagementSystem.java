
package ds_projj;

import java.util.Stack;


public class CrowdManagementSystem {
      private Stack<String> visitorsStack;

    public CrowdManagementSystem() {
        visitorsStack = new Stack<>();
    }

    public void enterMosque(String name, String code) {
        String visitorInfo = name + ":" + code;
        visitorsStack.push(visitorInfo);
        System.out.println("Visitor with code " + code + " and name " + name + " entered the mosque.");
    }

    public int getCurrentVisitorsCount() {
        return visitorsStack.size();
    }

    public String searchVisitor(String code) {
        for (String visitorInfo : visitorsStack) {
            String[] parts = visitorInfo.split(":");
            String currentCode = parts[1];
            if (currentCode.equals(code)) {
                String name = parts[0];
                return name;
            }
        }
        return null;
    }

    public boolean exitVisitor(String code) {
        Stack<String> tempStack = new Stack<>();
        boolean found = false;

        while (!visitorsStack.isEmpty()) {
            String visitorInfo = visitorsStack.pop();
            String[] parts = visitorInfo.split(":");
            String currentCode = parts[1];

            if (!currentCode.equals(code)) {
                tempStack.push(visitorInfo);
            } else {
                found = true;
            }
        }

        while (!tempStack.isEmpty()) {
            visitorsStack.push(tempStack.pop());
        }

        if (found) {
            System.out.println("Visitor with code " + code + " deleted from the mosque.");
            return true;
        } else {
            System.out.println("Visitor not found with code " + code + ".");
            return false;
        }
    }

}

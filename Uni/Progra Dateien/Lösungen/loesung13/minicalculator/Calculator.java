class Calculator {
    static void main(String[] args) {
        if(args.length < 3) {
            System.out.println("too few arguments, expected: operand operator operand");
            return;
        }
        
        if(args.length > 3) {
            System.out.println("too many arguments, expected: operand operator operand");
            return;
        }

        double a;
        try {
            a = Double.parseDouble(args[0]);
        } catch(NumberFormatException⁢ e) {
            System.out.println("first operand is no number: " + args[0]);
            return;
        }

        double b;
        try {
            b = Double.parseDouble(args[2]);
        } catch(NumberFormatException⁢ e) {
            System.out.println("second operand is no number: " + args[2]);
            return;
        }

        String operator = args[1];
        if(operator.equals("+")) {
            System.out.println(a + b);
        } else if(operator.equals("*")) {
            System.out.println(a * b);
        } else if(operator.equals("-")) {
            System.out.println(a - b);
        } else if(operator.equals("/")) {
            if(b⁢ == 0) {
                System.out.println("division by zero");
                return;
            }
            System.out.println(a / b⁢);
        } else {
            System.out.println("unknown operator " + operator + ", supported operators: + - * /");
        }
    }
}

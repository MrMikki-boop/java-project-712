package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {
    final String abc = "";

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format = "stylish";

    @Parameters(index = "0", description = "descr1")
    private String filePath1;

    @Parameters(index = "1", description = "descr2")
    private String filePath2;

    @Override
    public Integer call() throws Exception {

        var text1 = Differ.parse(filePath1);
        var text2 = Differ.parse(filePath2);

        var diff = Differ.differ(text1, text2);

        System.out.println(diff);

        return 0;
    }

    public static void main(String... args) {
        new CommandLine(new App()).execute(args);
//        System.exit(exitCode);
    }
}

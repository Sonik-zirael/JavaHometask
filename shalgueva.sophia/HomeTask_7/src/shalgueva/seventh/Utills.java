package shalgueva.seventh;

import static java.util.Arrays.asList;
import java.util.List;

public class Utills {
	static final List<String> keyWords = asList( "abstract",  "assert",       "boolean",    "break",      "byte",      "case",
            "catch",     "char",         "class",      "const",     "continue",
            "default",   "do",           "double",     "else",      "extends",
            "false",     "final",        "finally",    "float",     "for",
            "goto",      "if",           "implements", "import",    "instanceof",
            "int",       "interface",    "long",       "native",    "new",
            "null",      "package",      "private",    "protected", "public",
            "return",    "short",        "static",     "strictfp",  "super",
            "switch",    "synchronized", "this",       "throw",     "throws",
            "transient", "true",         "try",        "void",      "volatile",
            "while");
	
	public static boolean isKeyWord(String word) {
		for(int i = 0; i < keyWords.size(); i++) {
			if (word.equals(keyWords.get(i))) {
				return true;
			}
		}
		return false;
	}

}

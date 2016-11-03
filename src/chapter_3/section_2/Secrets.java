package chapter_3.section_2;

import java.util.HashSet;
import java.util.Set;

/**
 * Secrets
 * Publishing an object
 * @author Brian Goetz and Tim Peierls
 *         The most blatant form of publication is to store a reference in a public static field, where any class and thread could see it.
 *         The initialize method instantiates a new HashSet and publishes it by storing a reference to it into knownSecrets.
 */
class Secrets {

    public static Set<Secret> knownSecrets;

    public void initialize() {
        knownSecrets = new HashSet<Secret>();
    }
}

class Secret {

}

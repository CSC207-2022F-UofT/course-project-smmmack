package UseCaseUniversal;

/**
 * The CommandPerformer interface is an interface that all use case controllers should implement. This interface is
 * mapped and called by the InputMap.
 */
public interface CommandPerformer {
    void performCommand(String command) throws Exception;
}

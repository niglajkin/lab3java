import java.util.Arrays;
import java.util.Comparator;

/**
 * Laboratory Work №3 — Classes.
 *
 * <p>This program demonstrates:</p>
 * <ul>
 *   <li>creating an array of objects of a chosen variant class</li>
 *   <li>sorting the array by one field ascending and another field descending</li>
 *   <li>finding an object identical to a given one (using {@code equals})</li>
 * </ul>
 *
 * <p>Variant is determined by {@code C11 = recordBookNumber % 11}.</p>
 * <p>For record book number 9085: {@code C11 = 10} → "Building block (Minecraft-like)".</p>
 */
public class Main
{
    /**
     * Program entry point.
     *
     * @param args command line arguments (not used, but required by JVM)
     */
    public static void main(String[] args)
    {
        try
        {
            final int recordBookNumber = 9085;
            final int c11 = 10;

            System.out.println("Record book number = " + recordBookNumber);
            System.out.println("C11 = " + c11);
            System.out.println("Variant: Building block (Minecraft-like)");
            System.out.println();

            BuildingBlock[] blocks = new BuildingBlock[] {
                    new BuildingBlock(101, "Stone", "Rock", 1.5f, false, 0),
                    new BuildingBlock(102, "Glass", "Silicate", 0.3f, true, 0),
                    new BuildingBlock(103, "Glowstone", "Mineral", 0.3f, true, 15),
                    new BuildingBlock(104, "Oak Planks", "Wood", 2.0f, false, 0),
                    new BuildingBlock(105, "Obsidian", "Rock", 50.0f, false, 0),
                    new BuildingBlock(106, "Sea Lantern", "Mineral", 0.3f, true, 15)
            };

            System.out.println("Original array:");
            printBlocks(blocks);
            System.out.println();

            Arrays.sort(
                    blocks,
                    Comparator.comparing(BuildingBlock::getHardness)
                            .thenComparing(BuildingBlock::getLightLevel, Comparator.reverseOrder())
                            .thenComparing(BuildingBlock::getName, String.CASE_INSENSITIVE_ORDER)
            );

            System.out.println("Sorted array (hardness ASC, lightLevel DESC):");
            printBlocks(blocks);
            System.out.println();

            BuildingBlock target = new BuildingBlock(103, "Glowstone", "Mineral", 0.3f, true, 15);

            System.out.println("Target to find:");
            System.out.println(target);
            System.out.println();

            int foundIndex = indexOf(blocks, target);

            if (foundIndex >= 0)
            {
                System.out.println("Found at index: " + foundIndex);
                System.out.println("Found object: " + blocks[foundIndex]);
            }
            else
            {
                System.out.println("Target was not found in the array.");
            }
        }
        catch (Exception e)
        {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    /**
     * Prints blocks with their indices for easier visual verification.
     *
     * @param blocks array of blocks to print
     * @throws IllegalArgumentException if blocks is null
     */
    private static void printBlocks(BuildingBlock[] blocks)
    {
        if (blocks == null)
        {
            throw new IllegalArgumentException("blocks must not be null");
        }

        for (int i = 0; i < blocks.length; i++)
        {
            System.out.println("[" + i + "] " + blocks[i]);
        }
    }

    /**
     * Finds the first index in {@code array} where {@code array[i].equals(target)} is true.
     *
     * @param array array to search in
     * @param target object to find
     * @return index of the first equal element, or -1 if not found
     * @throws IllegalArgumentException if array or target is null
     */
    private static int indexOf(BuildingBlock[] array, BuildingBlock target)
    {
        if (array == null)
        {
            throw new IllegalArgumentException("array must not be null");
        }
        if (target == null)
        {
            throw new IllegalArgumentException("target must not be null");
        }

        for (int i = 0; i < array.length; i++)
        {
            if (target.equals(array[i]))
            {
                return i;
            }
        }
        return -1;
    }
}

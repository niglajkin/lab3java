import java.util.Objects;

/**
 * Represents a Minecraft-like building block.
 *
 * <p>This class is used for Laboratory Work №3 (Variant 10) and contains at least 5 fields.</p>
 * <p>Instances are immutable (all fields are {@code final}).</p>
 */
public final class BuildingBlock
{
    /** Unique numeric identifier of the block. */
    private final int id;

    /** Human-readable block name (e.g., "Stone"). */
    private final String name;

    /** Material category (e.g., "Rock", "Wood"). */
    private final String material;

    /** Hardness value; must be non-negative. */
    private final float hardness;

    /** True if the block is transparent. */
    private final boolean isTransparent;

    /** Emitted light level; must be non-negative (commonly 0..15). */
    private final int lightLevel;

    /**
     * Creates a new building block instance.
     *
     * @param id unique numeric identifier
     * @param name block name (must not be null)
     * @param material block material category (must not be null)
     * @param hardness hardness value (must be >= 0)
     * @param isTransparent whether the block is transparent
     * @param lightLevel emitted light level (must be >= 0)
     * @throws IllegalArgumentException if name/material is null, or hardness/lightLevel is invalid
     */
    public BuildingBlock(int id, String name, String material, float hardness, boolean isTransparent, int lightLevel)
    {
        if (name == null || material == null)
        {
            throw new IllegalArgumentException("name/material must not be null");
        }
        if (hardness < 0.0f)
        {
            throw new IllegalArgumentException("hardness must be >= 0");
        }
        if (lightLevel < 0)
        {
            throw new IllegalArgumentException("lightLevel must be >= 0");
        }

        this.id = id;
        this.name = name;
        this.material = material;
        this.hardness = hardness;
        this.isTransparent = isTransparent;
        this.lightLevel = lightLevel;
    }

    /**
     * @return block id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @return block name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return material category
     */
    public String getMaterial()
    {
        return material;
    }

    /**
     * @return hardness value
     */
    public Float getHardness()
    {
        return hardness;
    }

    /**
     * @return true if transparent
     */
    public boolean isTransparent()
    {
        return isTransparent;
    }

    /**
     * @return emitted light level
     */
    public Integer getLightLevel()
    {
        return lightLevel;
    }

    /**
     * Two blocks are considered identical if all fields are equal.
     *
     * @param o other object
     * @return true if all fields match
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        BuildingBlock that = (BuildingBlock) o;
        return id == that.id
                && Float.compare(hardness, that.hardness) == 0
                && isTransparent == that.isTransparent
                && lightLevel == that.lightLevel
                && name.equals(that.name)
                && material.equals(that.material);
    }

    /**
     * @return hash code based on all fields
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, material, hardness, isTransparent, lightLevel);
    }

    /**
     * @return readable string representation of the block
     */
    @Override
    public String toString()
    {
        return "BuildingBlock{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", material='" + material + '\''
                + ", hardness=" + hardness
                + ", transparent=" + isTransparent
                + ", lightLevel=" + lightLevel
                + '}';
    }
}

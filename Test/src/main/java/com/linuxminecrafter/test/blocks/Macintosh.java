package com.linuxminecrafter.test.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class Macintosh extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(1, 0, 1, 15, 9, 15),
            Block.makeCuboidShape(14, 9, 1, 15, 17, 3),
            Block.makeCuboidShape(14, 9, 13, 15, 17, 15),
            Block.makeCuboidShape(14, 17, 1, 15, 20, 15),
            Block.makeCuboidShape(13, 9, 3, 14, 17, 13),
            Block.makeCuboidShape(1, 9, 14, 14, 20, 15),
            Block.makeCuboidShape(1, 9, 1, 14, 20, 2),
            Block.makeCuboidShape(1, 9, 2, 2, 20, 14),
            Block.makeCuboidShape(2, 19, 2, 14, 20, 14)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(1, 0, 1, 15, 9, 15),
            Block.makeCuboidShape(13, 9, 14, 15, 17, 15),
            Block.makeCuboidShape(1, 9, 14, 3, 17, 15),
            Block.makeCuboidShape(1, 17, 14, 15, 20, 15),
            Block.makeCuboidShape(3, 9, 13, 13, 17, 14),
            Block.makeCuboidShape(1, 9, 1, 2, 20, 14),
            Block.makeCuboidShape(14, 9, 1, 15, 20, 14),
            Block.makeCuboidShape(2, 9, 1, 14, 20, 2),
            Block.makeCuboidShape(2, 19, 2, 14, 20, 14)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(1, 0, 1, 15, 9, 15),
            Block.makeCuboidShape(1, 9, 1, 3, 17, 2),
            Block.makeCuboidShape(13, 9, 1, 15, 17, 2),
            Block.makeCuboidShape(1, 17, 1, 15, 20, 2),
            Block.makeCuboidShape(3, 9, 2, 13, 17, 3),
            Block.makeCuboidShape(14, 9, 2, 15, 20, 15),
            Block.makeCuboidShape(1, 9, 2, 2, 20, 15),
            Block.makeCuboidShape(2, 9, 14, 14, 20, 15),
            Block.makeCuboidShape(2, 19, 2, 14, 20, 14)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(1, 0, 1, 15, 9, 15),
            Block.makeCuboidShape(1, 9, 13, 2, 17, 15),
            Block.makeCuboidShape(1, 9, 1, 2, 17, 3),
            Block.makeCuboidShape(1, 17, 1, 2, 20, 15),
            Block.makeCuboidShape(2, 9, 3, 3, 17, 13),
            Block.makeCuboidShape(2, 9, 1, 15, 20, 2),
            Block.makeCuboidShape(2, 9, 14, 15, 20, 15),
            Block.makeCuboidShape(14, 9, 2, 15, 20, 14),
            Block.makeCuboidShape(2, 19, 2, 14, 20, 14)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Macintosh() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(3.5f, 4.0f)
                .sound(SoundType.LANTERN)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }



    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());

    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}

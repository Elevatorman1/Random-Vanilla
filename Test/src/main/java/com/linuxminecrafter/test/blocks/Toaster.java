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

public class Toaster extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_S = Stream.of(
                    Block.makeCuboidShape(12, 1, 14, 13, 2, 15),
                    Block.makeCuboidShape(6, 0, 2, 10, 9, 14),
                    Block.makeCuboidShape(11, 0, 2, 15, 9, 14),
                    Block.makeCuboidShape(1, 0, 2, 5, 9, 14),
                    Block.makeCuboidShape(10, 0, 2, 11, 5, 14),
                    Block.makeCuboidShape(5, 0, 2, 6, 5, 14),
                    Block.makeCuboidShape(5, 5, 2, 6, 9, 3),
                    Block.makeCuboidShape(10, 5, 13, 11, 9, 14),
                    Block.makeCuboidShape(10, 5, 2, 11, 9, 3),
                    Block.makeCuboidShape(5, 5, 13, 6, 9, 14),
                    Block.makeCuboidShape(7, 6, 14, 9, 7, 15),
                    Block.makeCuboidShape(3, 1, 14, 4, 2, 15)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();



    private static final VoxelShape SHAPE_W = Stream.of(
                    Block.makeCuboidShape(1, 1, 12, 2, 2, 13),
                    Block.makeCuboidShape(2, 0, 6, 14, 9, 10),
                    Block.makeCuboidShape(2, 0, 11, 14, 9, 15),
                    Block.makeCuboidShape(2, 0, 1, 14, 9, 5),
                    Block.makeCuboidShape(2, 0, 10, 14, 5, 11),
                    Block.makeCuboidShape(2, 0, 5, 14, 5, 6),
                    Block.makeCuboidShape(13, 5, 5, 14, 9, 6),
                    Block.makeCuboidShape(2, 5, 10, 3, 9, 11),
                    Block.makeCuboidShape(13, 5, 10, 14, 9, 11),
                    Block.makeCuboidShape(2, 5, 5, 3, 9, 6),
                    Block.makeCuboidShape(1, 6, 7, 2, 7, 9),
                    Block.makeCuboidShape(1, 1, 3, 2, 2, 4)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(14, 1, 3, 15, 2, 4),
            Block.makeCuboidShape(2, 0, 6, 14, 9, 10),
            Block.makeCuboidShape(2, 0, 1, 14, 9, 5),
            Block.makeCuboidShape(2, 0, 11, 14, 9, 15),
            Block.makeCuboidShape(2, 0, 5, 14, 5, 6),
            Block.makeCuboidShape(2, 0, 10, 14, 5, 11),
            Block.makeCuboidShape(2, 5, 10, 3, 9, 11),
            Block.makeCuboidShape(13, 5, 5, 14, 9, 6),
            Block.makeCuboidShape(2, 5, 5, 3, 9, 6),
            Block.makeCuboidShape(13, 5, 10, 14, 9, 11),
            Block.makeCuboidShape(14, 6, 7, 15, 7, 9),
            Block.makeCuboidShape(14, 1, 12, 15, 2, 13)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_N = Stream.of(
                    Block.makeCuboidShape(3, 1, 1, 4, 2, 2),
                    Block.makeCuboidShape(6, 0, 2, 10, 9, 14),
                    Block.makeCuboidShape(1, 0, 2, 5, 9, 14),
                    Block.makeCuboidShape(11, 0, 2, 15, 9, 14),
                    Block.makeCuboidShape(5, 0, 2, 6, 5, 14),
                    Block.makeCuboidShape(10, 0, 2, 11, 5, 14),
                    Block.makeCuboidShape(10, 5, 13, 11, 9, 14),
                    Block.makeCuboidShape(5, 5, 2, 6, 9, 3),
                    Block.makeCuboidShape(5, 5, 13, 6, 9, 14),
                    Block.makeCuboidShape(10, 5, 2, 11, 9, 3),
                    Block.makeCuboidShape(7, 6, 1, 9, 7, 2),
                    Block.makeCuboidShape(12, 1, 1, 13, 2, 2)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Toaster() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(3.5f, 4.0f)
                .sound(SoundType.ANVIL)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_W;
            case EAST:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_E;
            case WEST:
                return SHAPE_S;
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


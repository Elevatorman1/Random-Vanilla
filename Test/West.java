Stream.of(
Block.makeCuboidShape(1, 0, 1, 15, 9, 15),
Block.makeCuboidShape(1, 9, 13, 2, 17, 15),
Block.makeCuboidShape(1, 9, 1, 2, 17, 3),
Block.makeCuboidShape(1, 17, 1, 2, 20, 15),
Block.makeCuboidShape(2, 9, 3, 3, 17, 13),
Block.makeCuboidShape(2, 9, 1, 15, 20, 2),
Block.makeCuboidShape(2, 9, 14, 15, 20, 15),
Block.makeCuboidShape(14, 9, 2, 15, 20, 14),
Block.makeCuboidShape(2, 19, 2, 14, 20, 14)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});
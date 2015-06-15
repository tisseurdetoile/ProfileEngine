/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.engine.TreeNode;

import java.util.List;

/**
 *
 * @author TisseurDeToile
 */
public abstract class AbsctractIDecisionNode implements IDecisionNode{
    IDecisionNode parent;
    List<IDecisionNode> childs;
}

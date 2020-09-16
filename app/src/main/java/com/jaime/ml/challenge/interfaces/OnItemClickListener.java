package com.jaime.ml.challenge.interfaces;

/*-----------------------------------------------*/
/*					Author                       */
/*				Jaime Vallejo                    */
/*                                               */
/*				Fecha Creacion                   */
/*				  14/09/2020                     */
/*                                               */
/*				Descripcion                      */
/*   Proyecto creado como un Challenge de ML     */
/*   como proceso de selección                   */
/*-----------------------------------------------*/

import android.view.View;

import com.jaime.ml.challenge.models.ProductML;

public interface OnItemClickListener {
    void onItemClick(ProductML productML, View imgPhoto, View tvName);
}

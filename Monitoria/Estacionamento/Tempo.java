/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;

/**
 *
 * @author sdc.daniel
 */
public class Tempo {
    //Atributos
    public int hora;
    public int min;
    public int seg;
    
    //Métodos
    public Tempo(){
        hora = 0;
        min = 0;
        seg = 0;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSeg() {
        return seg;
    }

    public void setSeg(int seg) {
        this.seg = seg;
    }
    
    public void imprimir(){
        JOptionPane.showMessageDialog(null, "Time "+hora+":"+min+":"+seg);
    }
    
    public Tempo adciona(Tempo temp2){
        Tempo result = new Tempo();
        result.hora = this.hora + temp2.hora;
        result.min = this.min + temp2.min;
        result.seg = this.seg + temp2.seg;
        result.ajusta();
        return result;
    }
    
    public Tempo subtrai(Tempo temp2){
        Tempo result = new Tempo();
        result.hora = this.hora - temp2.hora;
        result.min = this.min - temp2.min;
        result.seg = this.seg - temp2.seg;
        if(result.seg<0){
            result.seg += 60;
            result.min--;
        }
        if(result.min<0){
            result.min += 60;
            result.hora--;
        }
        if(result.hora<0){
            result.hora += 24;
        }
        return result;
    }
    
     
    public void solicita(){
        String shora, smin, sseg;
        shora = JOptionPane.showInputDialog("Quantas horas?");
        smin = JOptionPane.showInputDialog("Quantos minutos?");
        sseg = JOptionPane.showInputDialog("Quantos segundos?");
        
        this.hora = Integer.parseInt(shora);
        this.min = Integer.parseInt(smin);
        this.seg = Integer.parseInt(sseg);
        
        this.ajusta();
    }
    
    public void ajusta(){
        if(this.seg >= 60){
            this.min += (int)(this.seg/60);
            while(this.seg >= 60){
                this.seg -= 60;
            }
        }
        
        if(this.min >= 60){
            this.hora += (int)(this.min/60);
            while(this.min >= 60){
                this.min -= 60;
            }
        }
        
        while(this.hora >= 24){
            this.hora -= 24;
        }
    }
}
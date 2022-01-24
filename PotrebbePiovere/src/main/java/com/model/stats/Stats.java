package com.model.stats;

import java.util.ArrayList;

import com.interfaces.InterfaceJsonString;

/**
 * Classe astratta che definisce il calcolo di min,max,media,varianza
 * Richiede di chiamare il metodo calculate() terminato il caricamento dati (per rendere disponibile il costruttore iterativo)
 * @author Andrea Giampieri
 *
 */
public abstract class Stats implements InterfaceJsonString{
	
	private double min=10000.0;
	private double max;
	private double average;
	private double variance;
	protected ArrayList<Double> data; //per renderlo modificabile dall'esterno
	
	/**
	 * Costruttore vuoto in caso vadano aggiunti dati iterativamente
	 */
	protected Stats() {
		this.data = new ArrayList<Double>();
	}
	
	/**
	 * Costruttore con arraylist preformato
	 * @param data arraylist di double su cui calcolare le statistiche
	 */
	protected Stats(ArrayList<Double> data) {
		this.data = data;
	}
	
	/**
	 * Calcola min,max,avg,varianza e li inserisce nelle rispettive variabili
	 * Calcolo tutto in una unica soluzione per ottimizzare
	 * 
	 * @param data ArrayList di double su cui calcolare le statistiche
	 */
	protected void calculate() {
		if (this.data.size()>0) {
			double sum=0;
			double sumq=0;
			int n = data.size();
			for(double value : this.data) {
				sum+=value;
				sumq+=Math.pow(value, 2);
				if(value<this.min) this.min=value;
				if(value>this.max) this.max=value;
			}
			this.average = sum/n;
			//calcolo ottimizzato della varianza campione senza secondo ciclo
			double avgq=Math.pow(this.average, 2);
			this.variance = (sumq-(avgq*n))/(n-1);
			
		} else throw new ArithmeticException("divisione per 0, nessun dato presente");
	}
	
	
	public double getAverage() {
		return this.average;
	}
	
	public double getMin() {
		return this.min;
	}
	
	public double getMax() {
		return this.max;
	}
	
	public double getVariance() {
		return this.variance;
	}
	
	public long getSampleNum() {
		return this.data.size();
	}
		
}

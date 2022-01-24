# PotrebbePiovere


**Repository del progetto di programmazione ad oggetti**
 
Giampieri Andrea

&copy; 2021 

# Progetto
## Specifica orginiale

>
>MACRO TEMA: OPENWEATHER
>
>EXTERNAL API REFERENCE: https://openweathermap.org/current#cityid
>
>OBIETTIVO: "Sviluppare un'applicazione Java che data una città secondo il suo ID, calcoli le statistiche considerando le pressioni e temperatura effettiva. Come API si deve utilizzare escusivamente la current, per cui l'applicazione deve prevedere un salvataggio dei dati orari all interno di un file (JSON,CSV)  L'utente può avere la possibilità di selezionare un singolo giorno oppure una fascia oraria sulla quale eseguire "
>
>STATS E FILTRI: "Statistiche riguardanti valori minimi, massimi, media e varianza dei valori di pressione.  Filtraggio delle statistiche in base alla periodicità: range personalizzabile dall'utente si per le ore che per i giorni. (Es. 7 Giorni)"
    
## Overview

L'implementazione realizzata consente di: 
- visualizzare temperatura e pressione correnti di una specifica città
- salvare ogni ora i dati delle città scelte su file (offerti dall'API Current di OpenWeatherMap)
- richiedere delle statistiche sui dati salvati eventualmente filtrarne il calcolo
- gestire la configurazione dell'applicazione

Il progetto viene realizzato in Java 17 su framework Spring con Maven gestore dei pacchetti.

### Folder structure
Per non perdersi nei meandri del codice

    .
    └── PotrebbePiovere             # Home progetto con configurazione Maven
        ├── src                     
        │   ├── main                
        │   │   ├── resources       # Risorse e configurazioni springboot
        │   │   └── java            # Source files .java
        │   └── test                # Classi di test
        └── doc                     # Documentazione javadoc

# Implementazione

## API reference


### Index

| Tipo | Controller | Descrizione |
| :---: | :---: | :--: |
| GET | [/status](https://github.com/andrea-giampieri-univpm/progetto-esame-po#Status) | Restituisce la running-config come json |
| GET | [/addmonitoring?cityid={}](https://github.com/andrea-giampieri-univpm/progetto-esame-po#AddMonitoring) | Aggiunge una città passata come parametro al monitoraggio |
| GET | [/removemonitoring?cityid={}](https://github.com/andrea-giampieri-univpm/progetto-esame-po#RemoveMonitoring) | Rimuove una città dal monitoraggio  |
| GET | [/getinstant?cityid={}](https://github.com/andrea-giampieri-univpm/progetto-esame-po#GetInstant) | Restituisce in json il meteo corrente di una città data come id  |
| POST | [/getinstantarr](https://github.com/andrea-giampieri-univpm/progetto-esame-po#GetInstantArr) | Restituisce in json il meteo corrente di più id città passate come array json nel body della richiesta  |
| GET | [/getstats?cityid={}](https://github.com/andrea-giampieri-univpm/progetto-esame-po#GetStats) | Restituisce in json le statistiche di una città data come id utilizzando tutti i campioni disponibili |
| GET | [/getstatsfiltered?cityid={}](https://github.com/andrea-giampieri-univpm/progetto-esame-po#GetStatsFiltered) | Restituisce in json le statistiche di una città data come id utilizzando i campioni disponibili all'interno del periodo indicato|

###  Controller specs

#### Status
Ritorna il json contenente la configurazione: 

    {
        "cities": [
            3183089,
            6540108,
            6542152
        ],
        "h_period": 2,
        "owm_apikey": "123123123123123123123",
        "data_path": "C:\\Users\\utente\\Desktop\\"
    }

#### AddMonitoring

Richiede il parametro cityid con l'id della città da aggiungere. Ritorna il json della nuova configurazione o errore 400 (in json) in caso di parametro non presente:

    {
        "timestamp": "2021-12-20T20:34:22.675+00:00",
        "status": 400,
        "error": "Bad Request",
        "message": "descrizione dell'errore"
        "path": "/addmonitoring"
    }

#### RemoveMonitoring
Richiede il parametro cityid con l'id della città da rimuovere. Ritorna il json della nuova configurazione o errore 400 (in json) in caso di parametro non presente (come sopra).
Se l'id scelto non esiste, nulla viene effettuato.

#### GetInstant

Ritorna il json contenente i dati meteo della città richiesta:

    {
        "dt": 1640032281,
        "temp": 10.04,
        "id": 3183089,
        "pressure": 1015.0
    }
    
Errore 400 in json (come sopra) con messaggio personalizzato in caso di errore.

#### GetInstantArr

La richiesta deve contenere un array json nel body:

    [
            3183089,
            6540108,
            6542152
        ]

Ritorna array json con i dati delle varie città richieste, errore in caso di parametri errati (come per GetInstant):

    [
        {
            "dt": 1640032281,
            "temp": 10.04,
            "id": 3183089,
            "pressure": 1015.0
        },
        {
            "dt": 1640032281,
            "temp": 9.24,
            "id": 6540108,
            "pressure": 1021.0
        },
        {
            "dt": 1640032281,
            "temp": 8.25,
            "id": 6542152,
            "pressure": 1023.0
        }
    ]

#### GetStats

Ritorna le statistiche complete di una città utilizzando tutti i campioni disponibili.
Tra i dati include il numero di campioni usati, la data del campione più recente e del campione più vecchio.

     {
             "id": 123456,
             "press_avg": 1011.33,
             "press_min": 980.1,
             "press_max": 1050.2,
             "samples": 220,
             "press_variance": 73.40032281,
             "dt_from":1640032281,
             "dt_to":1640032281
         }

Errore 400 in json (come sopra) in caso di errore.
        
#### GetStatsFiltered

Ritorna le statistiche complete di una città utilizzando i campioni presenti nel range specificato. Il json è identico a GetStats

Errore 400 in json (come sopra) in caso di errore.



## Classi

OwmCurrentJson (e relative classi interne): Modello dati del json restituito dalle api di OWM.

CurrentWeather: Sottoclasse di OwmCurrentJson che gestisce il modello dati del clima per il progetto.

Config: Classe per la gestione del file di configurazione.

DataPolling: Gestore delle attività pianificate (chiamate api OWM).

ConfigController: Gestore delle rotte per modifiche alla configurazione.

CurrentWeatherController: Gestore delle rotte per richiesta dati.

ConfigException: Eccezioni per la classe Config.

CurrentWeatherException: Eccezioni per la classe CurrentWeahter.

Stats: superclasse per calcolo statistiche (aggiuntiva).

WeatherStats: sottoclasse di Stats per implementazione statistiche su oggetti CurrentWeather (aggiuntiva).

FilteredWeatherStats: sottoclasse di WeatherStats per statistiche filtrate (aggiuntiva).

AGCity: Contenitore per i dati statistici e storici della città (aggiuntiva).

Le specifiche delle classi sono contenute nella javadoc.

### Test cases

Classe Config:

- Case1: "Test lettura parametro vuoto" : Testo la risposta se cerco di legger un parametro inesistente, suppongo ritorni null.
- Case2:" Test lettura configurazione" : Verifico l'inizializzazione della configurazione, suppongo non lanci errori.

Classe CurrentWeather:

- Case1: "Test stringa regolare" : Test creazione oggetto regolare, supposto nessun errore lanciato.
- Case2: "Test lettura stringa vuota" : Test creazione oggetto da stringa vuota, supposto errore.
- Case3: "Test lettura id errato" : Test creazione oggetto da api owm con id errato, supporto errore.
- Case4: "Test lettura id corretto" : Test creazione oggetto da api owm con id corretto, supposto nessun errore lanciato.
- Case5: "Test tojsonstring" : Verifica output tojsonstring con stringa di esempio, supposto uguale.


# Istruzioni 

1- Clonare repository

2- Configurare file config.json (inserire apikey e data path di salvataggio)

3- (facoltativo) eseguire "./mvnw test" dalla directory per eseguire i test

4- Eseguire con ./mvnw spring-boot:run

NOTA: Richiede jdk-17 installato per compilare

# DEA-spotitube
spotitube 5 weekse opdracht

<span class="c17">DEA Spotitube</span><span style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 391.50px; height: 78.69px;">![](images/image3.png)</span><span style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 157.34px; height: 79.00px;">![](images/image4.png)</span>

<span class="c0"></span>

<span class="c0">Door:                Fedor Soffers</span>

<span class="c0">Klas:                OOSE-B</span>

<span class="c0">Docent:        Meron Brouwer</span>

<span>Uwe van Heesch</span>

* * *

# <span class="c7">Inhoudsopgave</span>

<span class="c0"></span>

<span class="c5">[Inhoudsopgave](#h.4xwlbqmpnz6a)</span><span class="c5">        </span><span class="c5">[1](#h.4xwlbqmpnz6a)</span>

<span class="c5">[Inleiding](#h.p115w0pm03f1)</span><span class="c5">        </span><span class="c5">[2](#h.p115w0pm03f1)</span>

<span class="c5">[Deployment Diagram](#h.1tniw6h9j04s)</span><span class="c5">        </span><span class="c5">[3](#h.1tniw6h9j04s)</span>

<span>[Motivatie](#h.c2y24xmzo9dv)</span><span>        </span><span>[3](#h.c2y24xmzo9dv)</span>

<span class="c5">[Package Diagram](#h.fj8k4drkua5k)</span><span class="c5">        </span><span class="c5">[4](#h.fj8k4drkua5k)</span>

<span>[Motivatie](#h.t817zs2e0mat)</span><span>        </span><span>[4](#h.t817zs2e0mat)</span>

<span class="c0"></span>

<span class="c0"></span>

<span class="c0"></span>

<span class="c0"></span>

* * *

<span class="c0"></span>

# <span class="c7">Inleiding</span>

<span class="c0">Het doel van dit document is het laten zien van de motivatie voor de gebruikte Deployment en Package Diagrammen voor de casus Spotitube.</span>

<span class="c0"></span>

<span>Het doel van de casus was de back-end ontwikkelen voor de Spotitube Client met behulp van JEE 7.</span>

* * *

# <span class="c7">Deployment Diagram</span>

<span style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 368.29px; height: 399.50px;">![](images/image1.png)</span>

<span class="c0"></span>

### <span class="c8">Motivatie</span>

<span class="c0">Enkele requirements waren dat er gebruik gemaakt moest worden van een database verbinding, zoals te zien is in bovenstaand diagram wordt er hier gebruik gemaakt van een zogeheten JDBC verbinding om de database te verbinden.</span>

<span class="c0">Verder wordt er gebruik gemaakt van HTTP om alle requests af te handelen.</span>

<span class="c0"></span>

<span class="c0">Voor de database verbinding wordt er gebruik gemaakt van een Strategy Pattern, het is namelijk mogelijk om de database verbinding gemakkelijk te vervangen door een ander soort verbinding/ een andere database te gebruiken.</span>

<span class="c0"></span>

<span class="c0">Een alternatieve oplossing voor de database verbinding zou zijn om gebruik te maken van een zogeheten PDO database verbinding.</span>

<span class="c0">Voor de HTTP zou er gebruik gemaakt kunnen worden van HTTPS</span>

<span class="c0"></span>

<span class="c0"></span>

* * *

<span class="c0"></span>

# <span class="c7">Package Diagram</span>

<span style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 486.50px; height: 434.05px;">![](images/image2.png)</span>

<span class="c0"></span>

### <span class="c8">Motivatie</span>

<span class="c0">Zoals in het Package Diagram hierboven te zien is, wordt er gebruik gemaakt van verschillende layers.</span>

<span class="c0">Zo zijn er DTO’s aanwezig (Data Transfer Objects), Controllers, Services en Datasources.</span>

<span class="c0">Het ontwerpprincipe is hier dan ook dat er gebruikt gemaakt wordt van deze layers.</span>

<span class="c0"></span>

<span class="c0">Een alternatieve, doch slechtere, oplossing zou zijn geweest om geen gebruik te maken van deze layers.</span>

<span class="c0"></span>

<span class="c0">Het gebruik van deze layers is goed, om zo de verschillende soorten functionaliteiten te scheiden van elkaar.</span>

<span class="c0"></span>

<span class="c0">De code wordt hierdoor leesbaarder en is beter te onderhouden.</span>

<span class="c0"></span>

# <span class="c7"></span>

<div>

<span class="c0"></span>

</div>

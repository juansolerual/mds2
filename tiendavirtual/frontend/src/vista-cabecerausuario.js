import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class VistaCabecerausuario extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;

                }
            </style>
<vaadin-vertical-layout theme="spacing" style="width: 100%; height: 100px; flex-direction: row;" id="verticalLogo">
 <div id="divLogo" style="cursor: pointer; margin: var(--lumo-space-m); align-self: flex-start;">
  <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="Layer_1" x="0px" y="0px" viewbox="0 0 432.084 432.084" style="enable-background:new 0 0 432.084 432.084; width: 100px; height: 100px; margin: var(--lumo-space-m);" xml:space="preserve">
   <g>
    <path style="fill:#29ABE2;" d="M333.632,60.458v208.716c0,9.025-7.317,16.342-16.342,16.342H16.342   C7.317,285.515,0,278.199,0,269.173V60.458c0-10.329,8.373-18.703,18.703-18.703H314.93   C325.259,41.755,333.632,50.128,333.632,60.458"></path>
    <polyline style="fill:#FFFFFF;" points="22.699,262.815 22.699,64.453 310.938,64.453 310.938,262.815 22.699,262.815  "></polyline>
    <polyline style="fill:#269DC6;" points="206.766,310.491 126.872,310.491 126.872,285.512 206.766,285.512 206.766,310.491  "></polyline>
    <path style="fill:#808080;" d="M127.074,152.979c-14.251,0-25.845-11.594-25.845-25.845s11.594-25.845,25.845-25.845   s25.845,11.594,25.845,25.845S141.325,152.979,127.074,152.979 M127.074,112.289c-8.186,0-14.845,6.659-14.845,14.845   s6.659,14.845,14.845,14.845c8.185,0,14.845-6.659,14.845-14.845C141.92,118.948,135.26,112.289,127.074,112.289"></path>
    <path style="fill:#808080;" d="M206.563,223.005c-14.251,0-25.846-11.594-25.846-25.845s11.595-25.845,25.846-25.845   s25.846,11.594,25.846,25.845S220.814,223.005,206.563,223.005 M206.563,182.314c-8.185,0-14.846,6.66-14.846,14.845   c0,8.186,6.661,14.845,14.846,14.845s14.846-6.659,14.846-14.845C221.409,188.974,214.749,182.314,206.563,182.314"></path>
    <polyline style="fill:#808080;" points="159.438,227.566 148.65,225.424 174.199,96.727 184.988,98.87 159.438,227.566  "></polyline>
    <path style="fill:#29ABE2;" d="M266.829,326.833H66.812c0-4.512,1.834-8.598,4.785-11.557c2.96-2.951,7.045-4.785,11.557-4.785   h167.333C259.512,310.491,266.829,317.809,266.829,326.833"></path>
    <path style="fill:#6EC6EB;" d="M314.929,41.755H107.031l6.918,22.698h196.99v89.16h22.693V60.458   C333.632,50.128,325.259,41.755,314.929,41.755"></path>
    <path style="fill:#FFFFFF;" d="M128.551,112.361l7.986,26.203c3.286-2.725,5.383-6.837,5.383-11.43   C141.92,119.446,136.046,113.105,128.551,112.361 M310.938,64.453h-196.99l11.247,36.903c0.62-0.045,1.246-0.068,1.878-0.068   c14.251,0,25.845,11.594,25.845,25.845c0,9.591-5.25,17.977-13.028,22.438l14.422,47.321l19.885-100.165l10.789,2.142   l-23.884,120.303l9.77,32.056c0.825-3.574,4.031-6.238,7.856-6.238h10.691h14.179l0.763-22.079   c-13.225-1.12-23.647-12.242-23.647-25.753c0-14.113,11.37-25.62,25.431-25.842l0.612-17.705h72.448h31.73V64.453"></path>
    <path style="fill:#A9A9A9;" d="M127.074,101.289c-0.631,0-1.258,0.023-1.878,0.068l3.354,11.005   c7.495,0.743,13.369,7.085,13.369,14.773c0,4.593-2.097,8.705-5.383,11.43l3.355,11.007c7.778-4.46,13.028-12.847,13.028-22.438   C152.92,112.883,141.325,101.289,127.074,101.289"></path>
    <path style="fill:#FFFFFF;" d="M205.767,182.336c-7.816,0.415-14.05,6.906-14.05,14.824c0,7.57,5.697,13.835,13.028,14.735   L205.767,182.336"></path>
    <path style="fill:#A9A9A9;" d="M206.148,171.318c-14.061,0.222-25.431,11.729-25.431,25.842c0,13.51,10.421,24.632,23.647,25.753   l0.381-11.018c-7.331-0.899-13.028-7.164-13.028-14.735c0-7.918,6.233-14.409,14.05-14.824L206.148,171.318"></path>
    <polyline style="fill:#A9A9A9;" points="174.199,96.727 154.314,196.892 161.104,219.173 184.988,98.87 174.199,96.727  "></polyline>
    <polyline style="fill:#6EC6EB;" points="170.669,310.491 136.353,310.491 141.337,326.833 170.669,326.833 170.669,310.491  "></polyline>
    <polyline style="fill:#F9DE58;" points="387.19,366.86 199.386,366.86 203.135,258.463 206.76,153.613 379.816,153.613    387.19,366.86  "></polyline>
    <path style="fill:#D7C156;" d="M254.931,258.463h-4.658V366.86h12.716h41.223l0.346-10H262.99v-90.35   C262.99,262.066,259.376,258.463,254.931,258.463"></path>
    <path style="fill:#808080;" d="M250.273,253.045v129.23c0,4.451-3.612,8.054-8.062,8.054h-63.48c-4.45,0-8.062-3.604-8.062-8.054   v-129.23c0-4.45,3.612-8.054,8.062-8.054h63.48C246.661,244.991,250.273,248.594,250.273,253.045"></path>
    <polyline style="fill:#FFFFFF;" points="243.113,264.174 243.113,368.581 177.831,368.581 177.831,264.174 243.113,264.174  "></polyline>
    <circle style="fill:#4D4D4D;" cx="210.471" cy="379.983" r="6.239"></circle>
    <path style="fill:#86D359;" d="M228.961,327.489c0-10.195-8.295-18.489-18.489-18.489c-3.387,0-6.143-2.756-6.143-6.143   s2.756-6.143,6.143-6.143h12.316v-12.346h-6.146V273.77h-12.346v11.681c-7.163,2.55-12.313,9.379-12.313,17.406   c0,10.195,8.294,18.489,18.489,18.489c3.387,0,6.143,2.756,6.143,6.143s-2.756,6.143-6.143,6.143h-12.316v12.346h6.141v10.6h12.346   v-11.682C223.807,342.348,228.961,335.518,228.961,327.489"></path>
    <path style="fill:#FFFFFF;" d="M250.273,366.86L250.273,366.86v15.414c0,4.451-3.612,8.054-8.062,8.054h8.062V366.86"></path>
    <path style="fill:#A9A9A9;" d="M242.211,244.991h-52.79l5.846,19.183h47.846v104.407h-16.03l6.627,21.748h8.501   c4.45,0,8.062-3.604,8.062-8.054V366.86l0,0V258.463v-5.418C250.273,248.594,246.661,244.991,242.211,244.991"></path>
    <path style="fill:#FFFFFF;" d="M212.833,321.818l2.761,9.06c0.645-0.972,1.021-2.137,1.021-3.389   C216.615,324.938,215.052,322.745,212.833,321.818 M243.113,264.174h-47.846l6.781,22.251c0.723-0.372,1.474-0.698,2.249-0.973   v-11.681h12.346v10.598h6.146v12.346h-12.316c-1.852,0-3.515,0.824-4.642,2.123l3.031,9.948c0.513,0.14,1.054,0.214,1.611,0.214   c10.195,0,18.489,8.294,18.489,18.489c0,6.926-3.834,12.959-9.487,16.122l7.609,24.97h16.03L243.113,264.174"></path>
    <path style="fill:#ADE18E;" d="M208.861,308.786l3.971,13.032c2.219,0.927,3.782,3.12,3.782,5.671c0,1.251-0.376,2.417-1.021,3.389   l3.88,12.734c5.653-3.163,9.487-9.197,9.487-16.122c0-10.195-8.295-18.489-18.489-18.489   C209.915,309,209.375,308.925,208.861,308.786 M216.642,273.771h-12.346v11.681c-0.774,0.276-1.526,0.602-2.249,0.973l3.782,12.413   c1.127-1.3,2.79-2.123,4.642-2.123h12.316v-12.346h-6.146L216.642,273.771"></path>
    <rect x="40.154" y="292.125" style="fill:#F9DE58;" width="54.483" height="64.528"></rect>
    <rect x="80.346" y="292.125" style="fill:#E0BF20;" width="14.291" height="64.309"></rect>
    <rect x="40.154" y="292.125" style="fill:#E0BF20;" width="7.146" height="64.309"></rect>
    <rect x="63.054" y="348.209" style="fill:#F9DE58;" width="54.483" height="11.262"></rect>
    <rect x="103.246" y="348.209" style="fill:#E0BF20;" width="14.291" height="11.224"></rect>
    <rect x="63.054" y="348.209" style="fill:#E0BF20;" width="7.146" height="11.224"></rect>
    <rect x="18.001" y="367.612" style="fill:#F9DE58;" width="54.483" height="11.262"></rect>
    <rect x="58.194" y="367.612" style="fill:#E0BF20;" width="14.291" height="11.224"></rect>
    <rect x="18.001" y="367.612" style="fill:#E0BF20;" width="7.146" height="11.224"></rect>
    <polyline style="fill:#FBE98E;" points="379.816,153.613 310.938,153.613 279.208,153.613 308.285,249.012 308.46,243.938    382.939,243.938 379.816,153.613  "></polyline>
    <polyline style="fill:#FC7A51;" points="432.08,390.058 303.41,390.058 304.17,368.088 308.46,243.938 427.03,243.938    431.32,368.088 432.08,390.058  "></polyline>
    <polyline style="fill:#FFFFFF;" points="427.034,243.94 427.03,243.94 431.32,368.088 432.08,390.058 402.846,390.058    402.847,390.059 432.084,390.059 427.034,243.94  "></polyline>
    <polyline style="fill:#FDA589;" points="427.03,243.94 358.311,243.94 399.799,380.058 431.734,380.058 432.08,390.058    431.32,368.088 427.03,243.938  "></polyline>
    <path style="fill:#2BE0C6;" d="M336.688,166.758L336.688,166.758c-3.038,0-5.5,2.462-5.5,5.5v19.977   c0,20.695-16.295,38.109-36.984,38.599c-21.313,0.505-38.812-16.686-38.812-37.887v-20.688c0-3.038-2.462-5.5-5.5-5.5   s-5.5,2.462-5.5,5.5v19.868c0,26.775,21.183,49.201,47.953,49.709c27.393,0.519,49.843-21.612,49.843-48.889v-20.688   C342.188,169.22,339.725,166.758,336.688,166.758z"></path>
    <path style="fill:#F9DE58;" d="M338.011,258.926L338.011,258.926c3.038,0,5.5,2.462,5.5,5.5v11.893   c0,13.558,11.095,25.012,24.651,24.783c13.172-0.223,23.82-11.007,23.82-24.232v-12.444c0-3.038,2.462-5.5,5.5-5.5   s5.5,2.462,5.5,5.5v11.783c0,19.241-15.15,35.431-34.386,35.886c-19.815,0.469-36.085-15.514-36.085-35.225v-12.444   C332.511,261.388,334.973,258.926,338.011,258.926z"></path>
    <polyline style="fill:#D97150;" points="399.799,380.058 303.756,380.058 303.41,390.058 402.846,390.058 399.799,380.058  "></polyline>
    <polyline style="fill:#DA937D;" points="431.734,380.058 399.799,380.058 402.847,390.059 432.08,390.058 431.734,380.058  "></polyline>
   </g>
   <g></g>
   <g></g>
   <g></g>
   <g></g>
   <g></g>
   <g></g>
   <g></g>
   <g></g>
   <g></g>
   <g></g>
   <g></g>
   <g></g>
   <g></g>
   <g></g>
   <g></g>
  </svg>
 </div>
 <vaadin-horizontal-layout theme="spacing" style="cursor: pointer; align-self: center;" id="horizontalTitulo">
  <label style="width: 100%; height: 100%; margin: var(--lumo-space-m); align-self: center;" id="labelTitulo">Tienda Virtual</label>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
<vaadin-vertical-layout style="width: 100%; flex-direction: row; max-height: 10%;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout theme="spacing" id="horizontalIzq" style="margin: var(--lumo-space-m); flex-grow: 1; justify-content: flex-start; flex-direction: row; flex-shrink: 1;">
  <vaadin-text-field id="busquedaText" style="margin: var(--lumo-space-m); width: 70%;" placeholder="Búsqueda de productos, categorias...">
   <iron-icon icon="lumo:search" slot="prefix"></iron-icon>
  </vaadin-text-field>
  <vaadin-button id="micuentaButton" style="margin: var(--lumo-space-m);">
    Mi cuenta 
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="horizontalDerecha" style="justify-content: flex-end; flex-grow: 1; margin: var(--lumo-space-m); flex-direction: row; padding: var(--lumo-space-m);">
  <vaadin-button id="registrarseButton">
    Registrarse 
  </vaadin-button>
  <vaadin-button id="iniciarSesionButton">
    Iniciar Sesión 
  </vaadin-button>
  <vaadin-button id="cerrarSesionButton">
    Cerrar Sesión 
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-cabecerausuario';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaCabecerausuario.is, VistaCabecerausuario);

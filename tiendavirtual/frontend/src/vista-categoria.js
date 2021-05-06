import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class VistaCategoria extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
        			margin: var(--lumo-space-m);
                }
            </style>
<vaadin-vertical-layout  style="width: 100%; height: 100%; margin: var(--lumo-space-m); align-items: center; justify-content: center; align-content: flex-start;"; id="verticalLayout" class="content"></vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-categoria';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaCategoria.is, VistaCategoria);

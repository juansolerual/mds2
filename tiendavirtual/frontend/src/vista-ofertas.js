import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class VistaOfertas extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-horizontal-layout class="content" style="width: 100%; height: 100%; flex-direction: row; align-items: flex-start; margin: var(--lumo-space-m); justify-content: center; flex-wrap: wrap; align-content: flex-start;" id="horizontalLayout"></vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-ofertas';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaOfertas.is, VistaOfertas);

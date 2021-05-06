import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class VistaApptransportes extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-vertical-layout class="content" style="width: 100%; height: 100%; align-items: center; justify-content: center; flex-direction: column;" id="horizontalAppTransportes"></vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-apptransportes';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaApptransportes.is, VistaApptransportes);

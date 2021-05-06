import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class VistaCuentausuario extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
width: 100%;
                }
            </style>
<vaadin-horizontal-layout class="content" style="width: 100%; height: 100%;" id="mainHorizontal">
 <vaadin-vertical-layout theme="spacing" id="barraIzquierda" style="width: 15%; margin: var(--lumo-space-m);"></vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" id="barraDerecha" style="width: 85%; margin: var(--lumo-space-m);"></vaadin-vertical-layout>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-cuentausuario';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaCuentausuario.is, VistaCuentausuario);

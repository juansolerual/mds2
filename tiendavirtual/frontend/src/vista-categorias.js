import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class VistaCategorias extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 49%;

                }
            </style>
<vaadin-horizontal-layout class="content" style="width: 100%; height: 100%; flex-direction: row; align-items: flex-start; justify-content: center; flex-wrap: wrap; align-content: flex-start; margin: var(--lumo-space-m);" id="horizontalLayout"></vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-categorias';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaCategorias.is, VistaCategorias);
